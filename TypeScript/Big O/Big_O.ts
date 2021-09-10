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
        if (array[i] === "nemo") {
            console.log("Found NEMO!");
        }
    }
}

findNemo(large); // O(n) ---> Linear Time
