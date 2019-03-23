import java.util.Scanner;
class CommandPattern{


	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args){
	 	RemoteControl rm = new RemoteControl(7);
		Light bulb = new Light();
		Command bulbOnCommand = new LightOnCommand(bulb);
		Command bulbOffCommand = new LightOffCommand(bulb);
		rm.setCommand(0,bulbOnCommand,bulbOffCommand);
		rm.onButtonPressed(0);
		while(true){
			String cc = sc.next();
			System.out.println("Command was : " + cc);
			if(cc.equals("ON")){
				rm.onButtonPressed(0);

			}else if(cc.equals("OFF")){
				rm.offButtonPressed(0);

			}else if(cc.equals("UNDO")){
				rm.undo();
			}else if(cc.equals("EXIT")){
				break;
			}

		}
	}



	static class RemoteControl{

		Command[] offCommands ;
		Command[] onCommands;

		Command undoCommand;

		public RemoteControl(int count){
			offCommands = new Command[count];
			onCommands = new Command[count];
			undoCommand = new NoCommand();

			for(int i=0;i<offCommands.length;i++){
				offCommands[i] = undoCommand;
				onCommands[i] = undoCommand;
			}

		}

		public void setCommand(int index,Command onCommand,Command ofCommand){
			offCommands[index] = ofCommand;
			onCommands[index] = onCommand;
		}


		public void onButtonPressed(int index){
			onCommands[index].execute();
			undoCommand = offCommands[index];
		}

		public void undo(){
			undoCommand.execute();
		}

		public void offButtonPressed(int index){
			offCommands[index].execute();
		    undoCommand = onCommands[index];
		}

}


		interface Command{

			public void execute();

			public void undo();

		}

		static class NoCommand implements Command{

			public NoCommand(){
				System.out.println("Blank Command Created !");
			}

			public void execute(){
				System.out.println(" No Command will not execute anything");
			}

			public void undo(){
				System.out.println("Not Applicable!");
			}

		}


		static class LightOnCommand implements Command{
			Light l;

			public LightOnCommand(Light l){
				this.l = l;
			}

			public void execute(){
				this.l.setLightOn();
			}

			public void undo(){
				System.out.println(" Undoing last command");
				this.l.setLightOff();
			}

		}

		static class LightOffCommand implements Command{
			Light l;

			public LightOffCommand(Light l){
				this.l = l;
			}

			public void execute(){
				this.l.setLightOff();
			}

			public void undo(){
				this.l.setLightOn();
			}

		}


		static class Light {

			private boolean on;

			Light(){
				System.out.println("Created Bulb of 100 watts");
			}

			public void setLightOn(){
				System.out.println(" Switching the light ON !");
				on = true;
			}

			public void setLightOff(){
				System.out.println(" Switching the light Off !");
				on = false;
			}

		}



}





