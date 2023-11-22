package Model;

class CompositeObjective implements Objective{
    private String description;
    private Objective[] objectives;

    protected CompositeObjective(String description, Objective[] objectives) {
        this.description = description;
        this.objectives = objectives;
    }

    @Override
    public boolean isComplete(Player player) {
        for (Objective objective : this.objectives) {
            if (!objective.isComplete(player)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}