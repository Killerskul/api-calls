package api.api_calls;


public class Main {
	public static void main(String[] args) throws Exception {
		

		if (args[2].equalsIgnoreCase("GET")) {
			Api api = new Api(args[0], args[1], args[2]);
			System.out.println(api.api_get());
		} else if (args[2].equalsIgnoreCase("POST") && args.length == 4) {
			Api api = new Api(args[0], args[1], args[2], args[3]);
			System.out.println(api.api_post());
		} else {
			throw new Exception("Provide arguments as follow '<URL> <API KEY> <ACTION - GET/POST>' '<FILE - ONLY FOR POST>'");
		}

	}

}
