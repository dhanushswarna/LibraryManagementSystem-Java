# 📚 Library Management System – Java (Console-Based CRUD Application)

A beginner-friendly **Core Java** project that demonstrates **CRUD operations**, **OOP concepts**, and **Collections** using a **menu-driven console interface**.  
This project is perfect for freshers preparing for interviews or learning Java fundamentals.

---

## 🚀 Project Features

- Add a new book  
- View all books  
- Update book details  
- Delete a book  
- Search book by ID  
- Search books by title (partial match)  
- Prevent duplicate book IDs  
- Simple, clean console-based UI  

---

## 🛠️ Technologies Used

- **Java (Core)**
- **ArrayList** for in-memory data storage  
- **OOP (Encapsulation, Classes, Objects)**
- **Optional API**
- **Java Stream API**
- **Scanner** for user input

---

## 📁 Project Structure


LibraryProject/
└── src/
└── library/
├── Book.java # Model class
├── Library.java # CRUD logic + storage
└── Main.java # Menu-driven console UI


---

## 📌 Classes Overview

### **1. Book.java**
- Represents the book entity.
- Contains fields: `id`, `title`, `author`, `year`, `copies`.
- Uses **encapsulation** (private fields + getters/setters).
- Overrides `toString()` for readable output.

---

### **2. Library.java**
- Acts as the service layer for all CRUD operations.
- Stores books in an `ArrayList<Book>`.
- Methods include:
  - `addBook()`
  - `getAllBooks()`
  - `updateBook()`
  - `deleteBook()`
  - `findById()`
  - `searchByTitle()`
- Uses **Optional**, **Streams**, and **Lambda expressions**.

---

### **3. Main.java**
- Contains the `main()` method.
- Provides a menu-driven console interface:

1) Add Book

2) View All Books

3) Update Book

4) Delete Book

5) Search by ID

6) Search by Title

7) Exit

- Reads user input with `Scanner`.
- Calls methods from `Library` class.

---

## ▶️ How to Run

### **In Eclipse**
1. Open Eclipse → File → New → Java Project  
2. Create project folder and package: `library`  
3. Add `Book.java`, `Library.java`, `Main.java`  
4. Right-click `Main.java` → **Run As → Java Application**

---

### **In VS Code**
1. Install **Java Extension Pack**  
2. Open the project folder  
3. Run using the “Run” button in `Main.java`  
 OR compile manually:


javac -d out src/library/*.java
java -cp out library.Main



---

## 📦 Sample Output

=== Library Management ===

Add Book

View All Books

Update Book

Delete Book

Search Book by ID

Search Book by Title

Exit
Choose an option:


---

## 🧠 Concepts Covered

- Classes & Objects  
- Constructors  
- Getters & Setters  
- ArrayList (CRUD storage)  
- Encapsulation  
- Method Overriding (`toString()`)  
- Scanner (I/O)  
- Optional & Stream API  
- Exception handling (`try/catch`)  
- Clean code structure (MVC-like separation)

---

## 🌟 Possible Enhancements

You can improve this project further:

### Beginner-Friendly Upgrades
- Save/Load books to a **CSV file**
- Add sorting (by year or title)
- Add input validations

### Intermediate Upgrades
- Convert ArrayList → Database (MySQL + JDBC)
- Add JUnit tests

### Advanced Upgrade
- Convert to REST API using **Spring Boot**
- Build a UI using HTML/React

---

## 📝 License
This project is open-source. Feel free to modify and use it for learning or interview preparation.

---

## 👨‍💻 Author
**Swarna Dhanush**

---

