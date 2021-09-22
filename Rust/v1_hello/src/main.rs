#[derive(Debug)]

pub struct Person {
    name: String,
    age: i32,
    children: i32,
}

impl Person {
    pub fn print(self) -> String {
        format!("name = {}, age = {}, has {} children", self.name, self.age, self.children)

    }
}

fn main() {
    let p = Person{
        name: "matt".to_string(),
        age: 35,
        children: 4
    };
    println!("Hello, people, from {:?}", p);
}
