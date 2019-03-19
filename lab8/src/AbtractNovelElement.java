abstract class AbtractNovelElement implements NovelElementIF {

    private NovelCompositeElement parent;
    private String name;

    @Override
    public NovelCompositeElement getParent() {
        return parent;
    }

    public void setParent(NovelCompositeElement p){
        this.parent = p;
    }

    @Override
    public abstract String getName();

    public abstract String getType();

    @Override
    public abstract int getCharLength();

    @Override
    public abstract void displayChildren();

    @Override
    public abstract int getElementCount();

}
