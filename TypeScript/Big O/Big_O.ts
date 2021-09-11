var nemo: Array<String> = ["nemo"];
var fishColony: Array<String> = [
    "dory",
    "bruce",
    "marlin",
    "nemo",
    "gill",
    "bloat",
    "nigel",
    "squirt",
    "darla",
    "hank",
];
var large: Array<String> = new Array(100).fill("nemo");

function findNemo(array: Array<String>) {
    for (let i = 0; i < array.length; i++) {
        console.log("Running!");
        if (array[i] === "nemo") {
            console.log("Found NEMO!");
            break;
        }
    }
}

findNemo(large); // O(n) ---> Linear Time

var boxes: Array<string | number> = [0, 1, 2, 3, 4, 5, 6];

function compressFirstBox(boxes: Array<String | number>) {
    console.log(boxes[0]);
}

compressFirstBox(large); // Time Complexity: O(1)

function logFirstTwoBoxes(boxes: Array<String | number>) {
    console.log(boxes[0]);
    console.log(boxes[1]);
}

logFirstTwoBoxes(boxes); // Time Complexity: O(2)
