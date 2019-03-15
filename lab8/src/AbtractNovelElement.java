abstract class AbtractNovelElement implements NovelElementIF {

    private NovelCompositeElement parent;

    @Override
    public NovelCompositeElement getParent() {
        return parent;
    }

    public void setParent(NovelCompositeElement p){
        this.parent = p;
    }

    @Override
    public abstract int getCharLength();

}
