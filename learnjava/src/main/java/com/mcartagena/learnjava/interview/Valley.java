package com.mcartagena.learnjava.interview;

import java.io.*;
import java.util.Scanner;

/*
An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly "steps", for every 
step it was noted if it was an uphill, U, or a downhill, D step. Hikes always start and end at sea level, and 
each step up or down represents a 1 unit change in altitude. We define the following terms:

- A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and 
ending with a step down to sea level.
- A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and 
ending with a step up to sea level.
Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.

Example

 steps = 8 
 path = [DDUUUUDD]

The hiker first enters a valley 2 units deep. Then they climb out and up onto a mountain 2 units high. Finally, 
the hiker returns to sea level and ends the hike.

Function Description

Complete the countingValleys function in the editor below.

countingValleys has the following parameter(s):

int steps: the number of steps on the hike
string path: a string describing the path
Returns

int: the number of valleys traversed

Input Format

The first line contains an integer "steps", the number of steps in the hike.
The second line contains a single string "path", of "steps" characters that describe the path.

Constraints

- 2 <= steps <= pow(10,6)
- path[i] = {U,D}

Sample Input

8
UDDDUDUU
Sample Output

1
Explanation

If we represent _ as sea level, a step up as /, and a step down as \, the hike can be drawn as:

_/\      _
   \    /
    \/\/
The hiker enters and leaves one valley.

*/

public class Valley {
  public static void main(String[] args) throws IOException {

    Scanner in = new Scanner(System.in);
    System.out.println("Number of Steps: ");
    int steps = in.nextInt();
    System.out.println("Path: ");
    String path = in.next();

    int result = Valley.countingValleys(steps, path);

    System.out.println("Output: ");
    System.out.println(String.valueOf(result));

    in.close();

  }

  /*
   * Complete the 'countingValleys' function below.
   *
   * The function is expected to return an INTEGER. The function accepts following
   * parameters: 1. INTEGER steps 2. STRING path
   */

  public static int countingValleys(int steps, String path) {
    // Write your code here
    int indicator = 0;
    boolean flagValley = false;
    int numberOfValleys = 0;

    for (int indexString = 0; indexString < path.length(); indexString++) {
      char element = path.charAt(indexString);
      switch (element) {
        case 'D':
          indicator--;
          if (indicator < 0) {
            flagValley = true;
          } else if (indicator == 0) {
            if (flagValley)
              numberOfValleys++;
          }
          break;
        case 'U':
          indicator++;
          if (indicator > 0) {
            flagValley = false;
          } else if (indicator == 0) {
            if (flagValley)
              numberOfValleys++;
          }
          break;
      }
    }

    return numberOfValleys;

  }

}
