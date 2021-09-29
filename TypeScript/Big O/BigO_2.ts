var boxes: Array<string | number> = [0, 1, 2, 3, 4, 5, 6];

function compressFirstBox(boxes: Array<String | number>) {
    console.log(boxes[0]);
}

compressFirstBox(boxes); // Time Complexity: O(1)

function logFirstTwoBoxes(boxes: Array<String | number>) {
    console.log(boxes[0]);
    console.log(boxes[1]);
}

logFirstTwoBoxes(boxes); // Time Complexity: O(2)
