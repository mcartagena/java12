package com.mcartagena.datastructure.graphs.socialnetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ShortestPath {
    /* Merge paths where searches met at connection */
    static LinkedList<Person> mergePaths(BFSData bfs1, BFSData bfs2, int connection) {
        PathNode end1 = bfs1.visited.get(connection);  // end1 -> source
        PathNode end2 = bfs2.visited.get(connection);  // end2 -> dest
        LinkedList<Person> pathOne = end1.collapse(false);
        LinkedList<Person> pathTwo = end2.collapse(true); // reverse
        pathTwo.removeFirst(); // remove connection
        pathOne.addAll(pathTwo); // add second path
        return pathOne;
    }

    static Person serachLevel(HashMap<Integer, Person> people, BFSData primary, BFSData secundary) {
        /* We only want to search one level at a time.  Count how many nodes are
         * currently in the primary's level and only do that many nodes.  We'll
         * continue to add nodes to the end.
         */
        int count = primary.toVisit.size();
        for (int i = 0; i < count; i++) {
            /* Pull out first node */
            PathNode pathNode = primary.toVisit.poll();
            int personId = pathNode.getPerson().getID();
            /* Check if it's already been visted */
            if (secundary.visited.containsKey(personId)) {
                return pathNode.getPerson();
            }
            /* Add friends to queue */
            Person person = pathNode.getPerson();
            ArrayList<Integer> friends = person.getFriends();
            for (int friendId : friends) {
                if (!primary.visited.containsKey(friendId)) {
                    Person friend = people.get(friendId);
                    PathNode next = new PathNode(friend, pathNode);
                    primary.visited.put(friendId, next);
                    primary.toVisit.add(next);
                }
            }
        }
        return null;
    }

    static LinkedList<Person> findPathBiBFS(HashMap<Integer, Person> people, int source, int destination) {
        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(destination));
        while (!sourceData.isFinished() && !destData.isFinished()) {
            /* Search out from source */
            Person collision = serachLevel(people, sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getID());
            }
            /* Search out from destination */
            collision = serachLevel(people, destData, sourceData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getID());
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Person uno = new Person(1);
        uno.setInfo("Uno");
        Person dos = new Person(2);
        dos.setInfo("Dos");
        Person tres = new Person(3);
        tres.setInfo("Tres");
        Person cuatro = new Person(4);
        cuatro.setInfo("Cuatro");
        Person cinco = new Person(5);
        cinco.setInfo("Cinco");

        uno.addFriend(2);
        uno.addFriend(3);
        dos.addFriend(1);
        dos.addFriend(4);
        tres.addFriend(1);
        tres.addFriend(5);
        cuatro.addFriend(2);
        cuatro.addFriend(5);
        cinco.addFriend(4);
        cinco.addFriend(3);

        HashMap<Integer, Person> people = new HashMap<>();
        people.put(1, uno);
        people.put(2, dos);
        people.put(3, tres);
        people.put(4, cuatro);
        people.put(5, cinco);

        LinkedList<Person> result = findPathBiBFS(people, 1, 4);

        System.out.println(result);

    }
}
