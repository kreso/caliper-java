/**
 * 
 */
package org.imsglobal.caliper.entities.lis;

import org.imsglobal.caliper.entities.schemadotorg.CreativeWork;

/**
 * @author pnayak
 * 
 */
public class LISCourseSection extends LISOrganization {

	private String label;
	private String courseNumber;
	private String semester; // TODO - check agains LIS LISOrganization

	/**
	 * 
	 */
	public LISCourseSection() {
		super();
		setType("http://purl.imsglobal.org/caliper/v1/LISCourseSection");
	}

	/**
	 * @param id
	 * @param parentOrg
	 */
	public LISCourseSection(String id, LISOrganization parentOrg) {
		super(id, parentOrg);
		setType("http://purl.imsglobal.org/caliper/v1/LISCourseSection");
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * @return the courseNumber
	 */
	public String getCourseNumber() {
		return courseNumber;
	}

	/**
	 * @param courseNumber
	 *            the courseNumber to set
	 */
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	/**
	 * @return the semester
	 */
	public String getSemester() {
		return semester;
	}

	/**
	 * @param semester
	 *            the semester to set
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}

}