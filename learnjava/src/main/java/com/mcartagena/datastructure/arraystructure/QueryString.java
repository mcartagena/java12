package com.mcartagena.datastructure.arraystructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class QueryString {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

/*        for(int i=0; i < queries.size(); i++){
            String query = queries.get(i);
            int count = 0;
            for(int j=0; j< strings.size(); j++){
                String str = strings.get(j);
                if(query.equals(str)){
                    count++;
                }
            }
            result.add(count);
        }*/

        return queries.stream().map(q -> Collections.frequency(strings,q)).collect(Collectors.toList());

    }

    public static void main(String[] args)  {
        List<String> strings = List.of("aba","baba","aba","xzxb");
        List<String> queries = List.of("aba","xzxb","ab");

        List<Integer> res = QueryString.matchingStrings(strings, queries);

        System.out.print(res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                + "\n" );
    }
}
