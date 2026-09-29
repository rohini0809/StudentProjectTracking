public class Project {

    private int projectId;
    private String projectName;
    private int studentId;
    private int progress;
    private String status;
    private int marks;
    private String feedback;

    public Project(int projectId, String projectName, int studentId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.studentId = studentId;
        this.progress = 0;
        this.status = "Not Started";
        this.marks = 0;
        this.feedback = "Not Evaluated";
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getProgress() {
        return progress;
    }

    public String getStatus() {
        return status;
    }

    public int getMarks() {
        return marks;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
