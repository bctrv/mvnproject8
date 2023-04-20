public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        String[] tmp = new String[0];
        for (String task : subtasks) {
            if (task.matches(query)) {
                return true;
            }
        }
        return false;
    }

}