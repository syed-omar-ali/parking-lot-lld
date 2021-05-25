import java.util.List;

public class Run {

    /***
     * Entry point
     * @param args: args[0] provides in the input file name.
     */
    public static void main(String[] args) {
        // Could have been injected using dependency injection
        CommandExecutorService commandExecutorService = new CommandExecutorService();

        if(args.length == 0){
            System.out.println("Please provide the input filename as argument to the program");
            System.exit(0);
        }
        List<String> commands = FileUtil.readFile(args[0]);
        if(commands == null){
            System.out.println("Could not load input file! Exiting ...");
            System.exit(0);
        }
        for(String command: commands){
            commandExecutorService.execute(command);
        }
    }
}
