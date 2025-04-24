package rules;

public class Rule {
    private String name;
    private String time;
    private String action;

    public Rule (String name, String time, String action){
        this.setName(name);
        this.setTime(time);
        this.setAction(action);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
