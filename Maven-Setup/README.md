# Maven Setup

### Maven is a dependency manager for Java projects, it helps keep track of the dependencies and their versions being used in the project

**Archetype**: Custom templates that we can create to build a particular projects.

- **`pom.xml` contains the dependency packages**
- **A package has 3 things: `groupId`, `artifactId` and `version`**
- `MVN Repository` is one of the sources to get the dependencies, just copy from there and paste in `pom.xml`


### How Maven Works ??
- All the dependencies that are there in the `pom.xml` files are first looked in the local machine by Maven, if it is not found then they are looked in the `Maven Central` and a copy of that dependency is stored in the local machine so that if Maven tries to find it again, it can find it directly in the local machine
