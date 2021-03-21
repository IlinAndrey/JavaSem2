package pr6.Builder;

public class Package {
    private final String kind;
    private final double size;
    private final String filling;
    private final int weight;

    public static class SendPackage{
        private String kind = "";
        private double size;
        private String filling = "";
        private int weight = 0;

        public SendPackage(String kind){
            this.kind = kind;
        }

        public SendPackage size(double size){
            this.size = size;
            return this;
        }

        public SendPackage filling(String filling){
            this.filling = filling;
            return this;
        }

        public SendPackage weight(int weight){
            this.weight = weight;
            return this;
        }

        public Package makePackage(){
            return new Package(this);
        }
    }

    private Package(SendPackage type){
        kind = type.kind;
        size = type.size;
        filling = type.filling;
        weight = type.weight;
    }

    @Override
    public String toString() {
        return "Package{" +
                "kind='" + kind + '\'' +
                ", size=" + size +
                ", filling='" + filling + '\'' +
                ", weight=" + weight +
                '}';
    }
}
