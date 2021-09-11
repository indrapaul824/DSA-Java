function funChallenge(input: Array<string>) {
    let a: number = 10; // O(1)
    a = 50 + 3; // O(1)

    for (let i = 0; i < input.length; i++) {
        // O(n)
        anotherFunction(); // O(n)
        let stranger: boolean = true; // O(n)
        a++; // O(n)
    }
    return a; // O(1)
}

function anotherFunction() {
    console.log("Another Function runs. We don't know what it is!");
}

// Total Complexity: 3*1 + 4*O(n) == O(3 + 4n) === O(n) ==> Linear Time
