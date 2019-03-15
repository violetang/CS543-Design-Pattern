import java.util.ArrayList;

public abstract class NovelCompositeElement extends AbtractNovelElement{

    private ArrayList<NovelElementIF> children = new ArrayList();
    private int cachedCharLength = -1;

    public NovelElementIF getChild(int index){
        return (NovelElementIF)children.get(index);
    }

    public synchronized void addChild(NovelElementIF child){
        synchronized (child){
            children.add(child);
            ((AbtractNovelElement)child).setParent(this);
            changeNotification();
        }
    }

    public synchronized void removeChild(AbtractNovelElement child){
        synchronized (child){
            if(this == child.getParent()){
                child.setParent(null);
            }
            children.remove(child);
            changeNotification();
        }
    }

    /**
     * A call to this method means that one of this object's
     * children has changed in a way that invalidates whatever
     * data this object may be caching about its children.
     */
    public void changeNotification(){
        cachedCharLength = -1;
        if(getParent() != null){
            getParent().changeNotification();
        }

    }

    public int getCharLength(){
        int len = 0;
        for(int i = 0 ; i < children.size(); i++){
            AbtractNovelElement thisChild;
            thisChild = (AbtractNovelElement)children.get(i);
            len += thisChild.getCharLength();
        }
        return len;
    }

}
