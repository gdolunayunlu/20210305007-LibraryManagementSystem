# YBS316 Object-Oriented Programming (OOP) Project
## Library Management System 

This project is a simple, console-based Java application developed for the YBS316 Object-Oriented Programming course. Its main goal is to simulate basic inventory management while serving as a practical demonstration of core OOP principles and required Java features.

### Project Topic
Library Management System : Manages and tracks inventory of various library items (Books and Magazines), and controls the rental status of rentable assets.

### Design and Architecture
The application is structured using a **Multitier Format** to separate responsibilities:
1.  **Data Layer (Entities):** `LibraryItem`, `Book`, `Magazine`, `IRentable`. Defines data and relationships.
2.  **Business Layer (Service):** `LibraryManager<T>`. Handles all core logic, collections, and filtering.
3.  **Presentation Layer (UI):** `Main`. Manages the text-based menu and user interaction.

### Implementation of Mandatory Technical Requirements

The project design strictly adheres to all assignment requirements by showcasing active usage of the following concepts:

| Requirement | Implementation in Code |
| :--- | :--- |
| **1. Inheritance** | Implemented through the **`LibraryItem`** (base class) and its subclasses (**`Book`** and **`Magazine`**). |
| **2. Interface** | The **`IRentable`** interface defines a contract for rental functions, which is implemented only by the **`Book`** class. |
| **3. Polymorphism** | Objects of different item types are managed uniformly using the **`LibraryItem`** reference type (e.g., in the `LibraryManager`'s listing and the `toString()` method overriding). |
| **4. Generic Class/Method** | The central **`LibraryManager<T>`** class is generic, constrained to manage only types that extend `LibraryItem`. |
| **5. Generic Collections (at least two)** | Two distinct collection types are utilized in the `LibraryManager`: **`List<T>`** (for iteration and filtering) and **`Map<Integer, T>`** (for efficient lookup by Item ID). |
| **6. Lambda Functions** | Used within the **`LibraryManager`** search functionality (e.g., `.filter(item -> ...)` and `.forEach()`) for dynamic, concise filtering of items. |
