/**
 * Created by borshtei on 16/04/2015.
 * entry point to create a new schema
 */
public class InstallerRunner {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("missing schema name argument");
        }
        String schemaName = args[0];
        SchemaManager manager = new SchemaManager();
        manager.createNewSchema(schemaName);
    }

}
