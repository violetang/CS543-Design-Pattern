class Task{
    
    private int taskId;
    private String description;
    private int status;

    Task(int i, String des){
        taskId = i;
        description = des;
        status = 0;
    }

    public int returnId(){
        return taskId;
    }

    //0 - new
    //1 - working on
    //2 - completed
    public void setStatus(int b){
        status = b;
    }
    public int getStatus(){ return status; }
    public String returnDes(){
        return description;
    }
}