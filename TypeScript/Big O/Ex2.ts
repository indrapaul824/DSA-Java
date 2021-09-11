function anotherFunChallenge(input: Array<string>) {
    let a = 5; // O(1)
    let b = 10; // O(1)
    let c = 50; // O(1)

    for (let i = 0; i < input.length; i++) {
        // O(n)
        let x = i + 1; // O(n)
        let y = i + 2; // O(n)
        let z = i + 3; // O(n)
    }

    for (let j = 0; j < input.length; j++) {
        // O(n)
        let p = j * 2; // O(n)
        let y = j * 2; // O(n)
    }

    let whoAmI = "I don't know!"; // O(1)
}

// Total Complexity: 4*1 + 7*O(n) == O(4 + 7n) === O(n) ==> Linear Time
