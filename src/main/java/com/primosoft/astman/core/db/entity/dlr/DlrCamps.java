package com.primosoft.astman.core.db.entity.dlr;

import com.primosoft.astman.core.db.entity.Model;
import com.primosoft.astman.core.db.entity.ats.ExtNumber;
import com.primosoft.astman.core.db.entity.ats.ORoutes;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Created on 28.09.16.
 *
 * @author atelizhenko
 */
@Entity
@Table(name = "camps", schema = "dlr")
@NamedQueries({
		@NamedQuery(name = "DlrCamps.findAll", query = "SELECT d FROM DlrCamps d")
})
public class DlrCamps implements Model<BigInteger> {
	private static final long serialVersionUID = 8052841026110896049L;

	private BigInteger id;
	private String name;
	private DlrCampStatuses dlrCampStatuses;
	private BigInteger operatorGroupId;
	private BigInteger operatorSelAlgId;
	private DlrMethods dlrMethods;
	private DlrMethodForms dlrMethodForms;
	private DlrSelAlgs dlrSelAlgs;
	private float force;
	private ExtNumber extNumber;
	private int maxRetry;
	private int maxACalls;
	private int dialTime;
	private int pid;
	private int lastCall;
	private DlrClosingTypes dlrClosingTypes;
	private String comment;
	private BigInteger callLimitingAlgorithmId;
	private DlrForceCorrectionAlgs dlrForceCorrectionAlgs;
	private BigInteger forceCorrectionTarget;
	private ORoutes oRoutes;

	@Id
	@Override
	@Column(name = "id")
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "status_id", referencedColumnName = "id")
	public DlrCampStatuses getDlrCampStatuses() {
		return dlrCampStatuses;
	}

	public void setDlrCampStatuses(DlrCampStatuses dlrCampStatuses) {
		this.dlrCampStatuses = dlrCampStatuses;
	}

	@Column(name = "operator_group_id")
	public BigInteger getOperatorGroupId() {
		return operatorGroupId;
	}

	public void setOperatorGroupId(BigInteger operatorGroupId) {
		this.operatorGroupId = operatorGroupId;
	}

	@Column(name = "operator_selalg_id")
	public BigInteger getOperatorSelAlgId() {
		return operatorSelAlgId;
	}

	public void setOperatorSelAlgId(BigInteger operatorSelAlgId) {
		this.operatorSelAlgId = operatorSelAlgId;
	}

	@ManyToOne
	@JoinColumn(name = "method_id", referencedColumnName = "id")
	public DlrMethods getDlrMethods() {
		return dlrMethods;
	}

	public void setDlrMethods(DlrMethods dlrMethods) {
		this.dlrMethods = dlrMethods;
	}

	@ManyToOne
	@JoinColumn(name = "method_form_id", referencedColumnName = "id")
	public DlrMethodForms getDlrMethodForms() {
		return dlrMethodForms;
	}

	public void setDlrMethodForms(DlrMethodForms dlrMethodForms) {
		this.dlrMethodForms = dlrMethodForms;
	}

	@ManyToOne
	@JoinColumn(name = "selalg_id", referencedColumnName = "id")
	public DlrSelAlgs getDlrSelAlgs() {
		return dlrSelAlgs;
	}

	public void setDlrSelAlgs(DlrSelAlgs dlrSelAlgs) {
		this.dlrSelAlgs = dlrSelAlgs;
	}

	@Column(name = "force")
	public float getForce() {
		return force;
	}

	public void setForce(float force) {
		this.force = force;
	}

	@ManyToOne
	@JoinColumn(name = "ext_number_id", referencedColumnName = "id")
	public ExtNumber getExtNumber() {
		return extNumber;
	}

	public void setExtNumber(ExtNumber extNumber) {
		this.extNumber = extNumber;
	}

	@Column(name = "def_maxretr")
	public int getMaxRetry() {
		return maxRetry;
	}

	public void setMaxRetry(int maxRetry) {
		this.maxRetry = maxRetry;
	}

	@Column(name = "max_acalls")
	public int getMaxACalls() {
		return maxACalls;
	}

	public void setMaxACalls(int maxACalls) {
		this.maxACalls = maxACalls;
	}

	@Column(name = "dial_time")
	public int getDialTime() {
		return dialTime;
	}

	public void setDialTime(int dialTime) {
		this.dialTime = dialTime;
	}

	@Column(name = "pid")
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Column(name = "last_call")
	public int getLastCall() {
		return lastCall;
	}

	public void setLastCall(int lastCall) {
		this.lastCall = lastCall;
	}

	@ManyToOne
	@JoinColumn(name = "closing_type_id", referencedColumnName = "id")
	public DlrClosingTypes getDlrClosingTypes() {
		return dlrClosingTypes;
	}

	public void setDlrClosingTypes(DlrClosingTypes dlrClosingTypes) {
		this.dlrClosingTypes = dlrClosingTypes;
	}

	@Column(name = "comment")
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "call_limiting_alg_id")
	public BigInteger getCallLimitingAlgorithmId() {
		return callLimitingAlgorithmId;
	}

	public void setCallLimitingAlgorithmId(BigInteger callLimitingAlgorithmId) {
		this.callLimitingAlgorithmId = callLimitingAlgorithmId;
	}

	@ManyToOne
	@JoinColumn(name = "force_correction_alg", referencedColumnName = "id")
	public DlrForceCorrectionAlgs getDlrForceCorrectionAlgs() {
		return dlrForceCorrectionAlgs;
	}

	public void setDlrForceCorrectionAlgs(DlrForceCorrectionAlgs dlrForceCorrectionAlgs) {
		this.dlrForceCorrectionAlgs = dlrForceCorrectionAlgs;
	}

	@Column(name = "force_correction_target")
	public BigInteger getForceCorrectionTarget() {
		return forceCorrectionTarget;
	}

	public void setForceCorrectionTarget(BigInteger forceCorrectionTarget) {
		this.forceCorrectionTarget = forceCorrectionTarget;
	}

	@ManyToOne
	@JoinColumn(name = "o_route_id", referencedColumnName = "id")
	public ORoutes getoRoutes() {
		return oRoutes;
	}

	public void setoRoutes(ORoutes oRoutes) {
		this.oRoutes = oRoutes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DlrCamps)) return false;
		DlrCamps dlrCamps = (DlrCamps) o;
		return Objects.equals(id, dlrCamps.id);
	}

	@Override
	public String toString() {
		return "DlrCamps{" +
				"id=" + id +
				", name='" + name + '\'' +
				", dlrCampStatuses=" + dlrCampStatuses +
				", operatorGroupId=" + operatorGroupId +
				", operatorSelAlgId=" + operatorSelAlgId +
				", dlrMethods=" + dlrMethods +
				", dlrMethodForms=" + dlrMethodForms +
				", dlrSelAlgs=" + dlrSelAlgs +
				", force=" + force +
				", extNumber=" + extNumber +
				", maxRetry=" + maxRetry +
				", maxACalls=" + maxACalls +
				", dialTime=" + dialTime +
				", pid=" + pid +
				", lastCall=" + lastCall +
				", dlrClosingTypes=" + dlrClosingTypes +
				", comment='" + comment + '\'' +
				", callLimitingAlgorithmId=" + callLimitingAlgorithmId +
				", dlrForceCorrectionAlgs=" + dlrForceCorrectionAlgs +
				", forceCorrectionTarget=" + forceCorrectionTarget +
				", oRoutes=" + oRoutes +
				'}';
	}
}
