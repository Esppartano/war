package Model;

class ConquerPlayer implements Objective{
    private final String description;
    private final String color;

    protected ConquerPlayer(String description, String color) {
        this.description = description;
        this.color = color;
    }

    @Override
    public boolean isComplete(Player player) {
        // checks if player is alive
        if(player.isAlive()){
            // checks if player has the color
            return false;
        }
        return player.getColor().equals(this.color);
    }

    @Override
    public String getDescription() {
        return this.description;
    }

}
