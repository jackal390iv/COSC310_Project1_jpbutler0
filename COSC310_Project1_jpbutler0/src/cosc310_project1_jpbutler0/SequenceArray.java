package cosc310_project1_jpbutler0;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Reaper
 */
public class SequenceArray {

    public static void test(int theSize, ArrayList inputFile) {
        int size = 0;
        String paper;
        int tempint;
        String type = null;
        String tempstr;
        int position1;
        int position2;
        int start1;
        String temp;
        int start2;
        int end;
        boolean value;
        int counter;
        int index;
        char tempcha;
        String[] theType = new String[theSize];

        LinkedList[] sequenceArray = new LinkedList[theSize];
        LinkedList freeList = new LinkedList();
        String tempList;

        do {
            paper = (String) inputFile.get(size);

            if (paper.contains("INSERT")) {

                paper = paper.replace("INSERT", "");
                paper = paper.trim();

                tempcha = paper.charAt(0);
                tempstr = Character.toString(tempcha);
                paper = paper.replace(tempstr, "");
                position1 = Integer.valueOf(tempstr);
                paper = paper.trim();

                tempcha = paper.charAt(0);
                if (paper.contains("DNA")) {
                    type = "DNA";
                } else if (paper.contains("RNA")) {
                    type = "RNA";
                }
                paper = paper.replace("DNA", "").replace("RNA", "");
                paper = paper.trim();

                if (theType[position1].contains(null)) {
                    counter = 0;
                    while (counter < paper.length()) {
                        value = true;
                        int i = 0;
                        temp = String.valueOf(paper.charAt(counter));
                        while ((value != false) || (i < freeList.size())) {
                            tempList = (String) freeList.get(i);
                            if (tempList.contains(temp)) {
                                sequenceArray[position1].add(freeList.get(i));
                                freeList.remove(i);
                                value = false;
                            }
                            i++;
                        }
                        if (value = true) {
                            sequenceArray[position1].add(temp);
                        }
                    }
                    theType[position1] = type;

                } else if (theType[position1].contains(type)) {
                    index = 0;

                    while (index != sequenceArray[position1].size()) {
                        tempList = (String) sequenceArray[position1].get(index);
                        freeList.add(tempList);
                    }

                    sequenceArray[position1].clear();
                    counter = 0;
                    while (counter < paper.length()) {
                        value = true;
                        int i = 0;
                        temp = String.valueOf(paper.charAt(counter));
                        while ((value != false) || (i < freeList.size())) {
                            tempList = (String) freeList.get(i);
                            if (tempList.contains(temp)) {
                                sequenceArray[position1].add(freeList.get(i));
                                freeList.remove(i);
                                value = false;
                            }
                            i++;
                        }
                        if (value = true) {
                            sequenceArray[position1].add(temp);
                        }

                    }

                }

            } else if (paper.contains("REMOVE")) {

                paper = paper.replace("REMOVE", "");
                paper = paper.trim();

                paper = paper.trim();
                position1 = paper.charAt(0);

                index = 0;

                while (index != sequenceArray[position1].size()) {
                    tempList = (String) sequenceArray[position1].get(index);
                    freeList.add(tempList);
                    index++;
                }

                sequenceArray[position1].clear();
            } else if (paper.contains("PRINT")) {
                paper = paper.replace("PRINT", "");
                paper = paper.trim();

                if (!(paper.isEmpty())) {
                    paper = paper.trim();
                    position1 = paper.charAt(0);

                    sequenceArray[position1].toString();

                } else {
                    for (int i = 0; i < theSize; i++) {
                        sequenceArray[i].toString();
                    }
                }
            } else if (paper.contains("CLIP")) {

                paper = paper.replace("CLIP", "");
                paper = paper.replaceAll(" ", "");

                tempint = paper.length();
                if (tempint > 2) {
                    position1 = paper.charAt(0);
                    start1 = paper.charAt(1);
                    end = paper.charAt(2);
                    LinkedList temporary = null;

                    while ((start1 != sequenceArray[position1].size())
                            && (start1 < end)) {
                        tempList = (String) sequenceArray[position1]
                                .get(start1);
                        temporary.add(tempList);
                        start1++;
                    }

                    index = 0;
                    while (index != sequenceArray[position1].size()) {
                        tempList = (String) sequenceArray[position1].get(index);
                        freeList.add(tempList);
                        index++;
                    }
                    sequenceArray[position1].clear();

                    index = 0;
                    while (index != temporary.size()) {
                        tempList = (String) temporary.get(index);
                        sequenceArray[position1].add(tempList);
                        index++;
                    }
                } else {
                    position1 = paper.charAt(0);
                    start1 = paper.charAt(1);

                    LinkedList temporary = null;

                    while (start1 != sequenceArray[position1].size()) {
                        tempList = (String) sequenceArray[position1]
                                .get(start1);
                        temporary.add(tempList);
                        start1++;
                    }

                    index = 0;
                    while (index != sequenceArray[position1].size()) {
                        tempList = (String) sequenceArray[position1].get(index);
                        freeList.add(tempList);
                        index++;
                    }
                    sequenceArray[position1].clear();

                    index = 0;
                    while (index != temporary.size()) {
                        tempList = (String) temporary.get(index);
                        sequenceArray[position1].add(tempList);
                        index++;
                    }
                }
            } else if (paper.contains("SWAP")) {

                paper = paper.replace("SWAP", "");
                paper = paper.replaceAll(" ", "");

                position1 = paper.charAt(0);
                start1 = paper.charAt(1);

                position2 = paper.charAt(2);
                start2 = paper.charAt(3);

                LinkedList temporary = null;

                for (int i = start1; i < sequenceArray[position1].size(); i++) {
                    tempstr = (String) sequenceArray[position1].get(i);
                    temporary.add(tempstr);
                    sequenceArray[position1].remove(i);
                }

                for (int i = start2; i < sequenceArray[position2].size(); i++) {
                    tempstr = (String) sequenceArray[position2].get(i);
                    sequenceArray[position1].add(tempstr);
                    sequenceArray[position2].remove(i);
                }
                for (int i = 0; i < temporary.size(); i++) {
                    tempstr = (String) temporary.get(i);
                    sequenceArray[position2].add(tempstr);
                }
                temporary.clear();
            } else if (paper.contains("OVERLAP")) {

                paper = paper.replace("OVERLAP", "");
                paper = paper.replaceAll(" ", "");

                position1 = paper.charAt(0);
                position2 = paper.charAt(1);

                // ------------------------------------------------------------
            } else if (paper.contains("TRANSCRIBE")) {

                paper = paper.replace("TRANSCRIBE", "");
                paper = paper.replaceAll(" ", "");

                position1 = paper.charAt(0);

                index = 0;

                while (index != sequenceArray[position1].size()) {
                    tempList = (String) sequenceArray[position1].get(index);
                    if (tempList.contains("U")) {
                        freeList.add(tempList);
                        sequenceArray[position1].remove(index);
                        value = true;

                        int i = 0;
                        while ((value != false) || (i < freeList.size())) {
                            tempList = (String) freeList.get(i);
                            if (tempList.contains("T")) {
                                sequenceArray[position1].add(freeList.get(i));
                                freeList.remove(i);
                                value = false;
                            }
                            i++;
                        }
                        if (value = true) {
                            sequenceArray[position1].add(index, "T");
                        }

                    } else if (tempList.contains("T")) {
                        freeList.add(tempList);
                        sequenceArray[position1].remove(index);
                        value = true;
                        int i = 0;
                        while ((value != false) || (i < freeList.size())) {
                            tempList = (String) freeList.get(i);
                            if (tempList.contains("U")) {
                                sequenceArray[position1].add(freeList.get(i));
                                freeList.remove(i);
                                value = false;
                            }
                            i++;
                        }
                        if (value = true) {
                            sequenceArray[position1].add(index, "U");
                        }

                    }
                }
            }
            size++;

        } while (size != inputFile.size());

    }
}
