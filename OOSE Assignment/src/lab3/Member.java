package lab3;


/**
 * 學校成員
 */
public class Member {
	
	/**
     * 名稱
     */
    private String name;

    /**
     * 編號
     */
    private String ID;

    /**
     * 電話
     */
    private String tel;

    /**
     * Default constructor
     */
    public Member(String name) {
    	this.name = name;
    }
    
    /**
     * 有進入學校時, 獲得ID成為學校成員的Constructor
     * @param name
     * @param ID
     */
    public Member(String name, String ID) {
    	this.name = name;
    	this.ID = ID;
    }

    /**
     * = toString
     */
    public void show() {
        String string = "Member name: " + name + ", ID: " + ID + ", tel: " + tel;
        System.out.println(string);
    }

	/**
     * 
     */
    public void queryCourse() {
        // TODO implement here
    }
    
    /**
     * 獲取姓名
     * @return
     */
    public String getName() {
    	return name;
    }
    
    /**
     * 獲取ID
     * @return
     */
    public String getID() {
    	return ID;
    }

}