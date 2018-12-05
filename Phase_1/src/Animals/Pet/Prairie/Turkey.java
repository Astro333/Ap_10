package Animals.Pet.Prairie;

import Animals.Pet.Pet;
import Items.Item;

public class Turkey extends Pet {
    public Turkey(int x, int y) {
        super(x, y, AnimalType.Turkey);
    }

    @Override
    public Item produce() {
        return new Item(Item.ItemType.Egg);
    }
}
