var nemo: Array<String> = ["nemo"];

function findNemo(array: Array<String>) {
  for (let i = 0; i < array.length; i++) {
    if (array[i] == "nemo") {
      console.log("Found NEMO!");
    }
  }
}

findNemo(nemo);
