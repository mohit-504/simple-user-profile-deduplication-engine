# User Profile Deduplication Engine

A Java backend project that simulates how large-scale systems detect duplicate users, resolve identities, merge profile information, and sort user profiles using different strategies.

## Problem Statement

Large systems often receive duplicate user records from multiple sources.

Example:

```text
U1 -> alice@test.com
U2 -> alice@test.com
```

The system should:

* Detect duplicate profiles
* Resolve identities
* Merge profile information
* Support multiple sorting strategies

---

## Setup

### Download Lombok

Download Lombok from:

https://projectlombok.org/download

Place the JAR inside:

```text
lib/
└── lombok.jar
```

### VS Code Configuration

Create or update:

```text
.vscode/settings.json
```

```json
{
    "java.project.referencedLibraries": [
        "lib/**/*.jar"
    ]
}
```

This allows VS Code to include Lombok in the project classpath.

---

## Features

### Lombok

Used Lombok annotations to reduce boilerplate:

* @Getter
* @Setter
* @ToString
* @RequiredArgsConstructor
* @AllArgsConstructor

### Deduplication

Implemented duplicate detection using:

```java
HashSet<UserProfile>
```

with custom:

```java
equals()
hashCode()
```

based on email identity.

### Identity Resolution

Implemented profile lookup and merging using:

```java
HashMap<String, UserProfile>
```

where:

```text
email -> profile
```

### Profile Merging

Duplicate profiles are merged using simple conflict-resolution rules:

* Keep original userId
* Keep email identity
* Use latest non-empty name
* Use latest non-empty phone
* Keep most recent timestamp

### Sorting

Implemented:

* Comparable (natural ordering by userId)
* NameComparator
* EmailComparator
* LastUpdatedComparator

---

## Project Structure

```text
src/
└── project
    ├── comparator
    ├── dedup
    ├── merge
    ├── model
    ├── utils
    └── Main.java
```

---

## Concepts Covered

* Lombok
* equals() and hashCode()
* HashSet
* HashMap
* Identity Resolution
* Profile Merging
* Comparable
* Comparator
* Java Collections Framework

---

## Concurrency Discussion

The current implementation is single-threaded.

In real systems, simultaneous profile ingestion can cause race conditions. Production systems typically use:

```java
ConcurrentHashMap
```

and atomic operations such as:

```java
compute()
merge()
putIfAbsent()
```

to ensure thread safety.

---

## Resume Bullet

Built a User Profile Deduplication Engine in Java that performed hash-based identity matching, profile deduplication, conflict-aware profile merging, and multi-strategy user sorting using Comparable and Comparator patterns.
