/**
 * NovelElementIF.java
 */
public interface NovelElementIF {
    public NovelCompositeElement getParent();
    public int getCharLength();
    public void displayChildren(String space);
    public int getElementCount();
    public String getName();
    public String getType();
}
