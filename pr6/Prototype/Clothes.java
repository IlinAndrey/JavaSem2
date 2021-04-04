package pr6.Prototype;

public class Clothes {
    private ClothesType type;

    public Clothes(){
    }

    public Clothes(ClothesType type){
        this.type = type;
    }

    public ClothesType getType() {
        return type;
    }

    public void setType(ClothesType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "type=" + type +
                '}';
    }
}
