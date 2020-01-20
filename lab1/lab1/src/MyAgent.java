import java.util.Collection;

public class MyAgent implements Agent
{
    String current_state = "TURN_ON";
    int turn = 0;
    int y = 0;
    int x = 0;
    boolean left_finish = true;
    public String nextAction(Collection<String> percepts) {
		for(String percept:percepts) {
			System.out.print("'" + percept + "', ");
        }
		System.out.println("");
        String[] actions = { "TURN_ON", "TURN_OFF", "TURN_RIGHT", "TURN_LEFT", "GO", "SUCK" };
        String[] states = { "TURN_ON", "FIND WALL", "FIND CORNER", "RIGHT SUCK", "RIGHT TURN", "LEFT SUCK", "LEFT TURN", "GO HOME","GO Y"};
        switch(current_state){
            case "TURN_ON":
                current_state = states[1];
                return actions[0];
            case "FIND WALL":
                if(percepts.contains("BUMP")){
                    x--;
                    current_state = states[2];
                    return actions[2];
                }
                else{
                    x++;
                    return actions[4];
                }
            case "FIND CORNER":
                if(percepts.contains("BUMP")){
                    y--;
                    current_state = states[3];
                    return actions[2];
                }
                else{
                    y++;
                    return actions[4];
                }
            case "RIGHT SUCK":
                if(percepts.contains("DIRT")) return actions[5];
                else if(percepts.contains("BUMP")){
                    x++;
                    current_state = states[4];
                    return actions[2];
                }
                else{
                    x--;
                    return actions[4];
                }
            case "RIGHT TURN":
                if(turn == 0){
                    y--;
                    turn++;
                    return actions[4];
                } 
                else{
                    turn = 0;
                    if(percepts.contains("BUMP")){
                        x = Math.abs(x);
                        left_finish = false;
                        y++;
                        current_state = states[7];
                        return actions[2];
                    }
                    current_state = states[5];
                    return actions[2];
                }

            case "LEFT SUCK":
                if(percepts.contains("DIRT")) return actions[5];
                else if(percepts.contains("BUMP")){
                    x--;
                    current_state = states[6];
                    return actions[3];
                }
                else{
                    x++;
                    return actions[4];
                }
            case "LEFT TURN":
                if(turn == 0){
                    y--;
                    turn++;
                    return actions[4];
                }
                else{
                    turn = 0;
                    if(percepts.contains("BUMP")){
                        y++;
                        current_state = states[7];
                        return actions[3];
                    }
                    current_state = states[3];
                    return actions[3];
                }
            case "GO HOME":
                if(x==0 && y==0){
                    return actions[1];
                }
                else if(x != 0){
                    x--;
                    return actions[4];
                }
                else{
                    current_state = states[8];
                    if(left_finish) return actions[3];
                    else return actions[2];
                }
            case "GO Y":
                if(y != 0){
                    y++;
                    return actions[4];
                }
                else return actions[1];

        }
        return actions[1];
	}
}