package Model;

class DestructionObjective implements Objective {
    private String description;
    private Player target;

    protected DestructionObjective(String description, Player target) {
        this.description = description;
        this.target = target;
    }

    public boolean isComplete(Player player) {
        return !this.target.isAlive();
    }

    public String getDescription() {
        return this.description;
    }
}