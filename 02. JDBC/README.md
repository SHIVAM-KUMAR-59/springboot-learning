# Java Database Connectivity (JDBC)
### Steps required:
- **Download the `.jar` file for postgres JDBC and add it in the external libraries of the project**
- **Import the required package `java.sql`**
- **Load the driver**
- **Register the driver**
- **Create connection**
- **Execute a statement or query**
- **Process the result**
- **Close the connection**

### Issues with Statement:
- **Concatenations are very difficult when working with variables instead of direct values**
- **Prone to SQL injections**
- **Does not cache the query**
**All these are solved using PreparedStatement**