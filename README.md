# Concurrent Programming Concepts and Examples

This ticket-booking code have set of Java examples that demonstrate various locking mechanisms. These examples are designed to illustrate how concurrency and synchronization are handled in Java applications.

## Implemented Concepts:

### ReentrantLock

- **lock.lock():**
    - Acquires the lock, blocking until it's available.

- **lock.lockInterruptibly():**
    - Acquires the lock unless the current thread is interrupted.

- **lock.tryLock(1, TimeUnit.SECONDS):**
    - Attempts to acquire the lock, waiting up to 1 second before giving up.

### synchronized Keyword

- **synchronized Keyword:**
    - Illustrates the behavior of the synchronized keyword in Java.

## Source Code Structure:

To facilitate understanding, I've organized the examples into different packages, each focusing on a specific locking mechanism:

- **org.example.ex1:** Demonstrates the use of `lock.lock()`.
- **org.example.ex2:** Illustrates the behavior of the `synchronized` keyword.
- **org.example.ex3:** Shows examples using `lock.lockInterruptibly()`.
- **org.example.ex4:** Highlights the usage of `lock.tryLock(1, TimeUnit.SECONDS)`.

## Instructions:

To observe the output of each example, run the Main class located in each respective package. This will execute the demonstration specific to that locking mechanism.

