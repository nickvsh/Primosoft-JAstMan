/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.ats;

import com.primosoft.astman.core.db.entity.Model;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Created on 08.06.16.
 *
 * @author atelizhenko
 */
@Entity
@Table(name = "sip_users", schema = "ats", catalog = "asterisk")
@NamedQueries({
		@NamedQuery(name = "SipUsers.findAll", query = "SELECT s FROM SipUser s")
})
public class SipUser implements Model<BigInteger> {
	private static final long serialVersionUID = 4532284158766575824L;

	private BigInteger id;
	private String accountcode;
	private String disallow;
	private String allow;
	private String allowoverlap;
	private String allowsubscribe;
	private String allowtransfer;
	private String amaflags;
	private String autoframing;
	private String auth;
	private String buggymwi;
	private String callgroup;
	private String callerid;
	private String cidNumber;
	private String fullname;
	private Integer callLimit;
	private String callingpres;
	private String canreinvite;
	private String context;
	private String defaultip;
	private String dtmfmode;
	private String fromuser;
	private String fromdomain;
	private String fullcontact;
	private String g726Nonstandard;
	private String host;
	private String insecure;
	private String ipaddr;
	private String language;
	private String lastms;
	private String mailbox;
	private Integer maxcallbitrate;
	private String mohsuggest;
	private String md5Secret;
	private String musiconhold;
	private String name;
	private String nat;
	private String outboundproxy;
	private String deny;
	private String permit;
	private String pickupgroup;
	private String port;
	private String progressinband;
	private String promiscredir;
	private String qualify;
	private String regexten;
	private Long regseconds;
	private String rfc2833Compensate;
	private String rtptimeout;
	private String rtpholdtimeout;
	private String secret;
	private String sendrpid;
	private String setvar;
	private String subscribecontext;
	private String subscribemwi;
	private String trustrpid;
	private String type;
	private String useclientcode;
	private String defaultuser;
	private String usereqphone;
	private String videosupport;
	private String vmexten;
	private String t38PtUdptl;
	private String useragent;
	private String username;
	private String regserver;

	public SipUser(BigInteger id, String ipaddr) {
		this.id = id;
		this.ipaddr = ipaddr;
	}

	public SipUser() {
	}

	/**
	 * Getter
	 *
	 * @return id
	 */
	@Id
	@Column(name = "id", nullable = false)
	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@Basic
	@Column(name = "accountcode", length = -1)
	public String getAccountcode() {
		return accountcode;
	}

	public void setAccountcode(String accountcode) {
		this.accountcode = accountcode;
	}

	@Basic
	@Column(name = "disallow", length = -1)
	public String getDisallow() {
		return disallow;
	}

	public void setDisallow(String disallow) {
		this.disallow = disallow;
	}

	@Basic
	@Column(name = "allow", length = -1)
	public String getAllow() {
		return allow;
	}

	public void setAllow(String allow) {
		this.allow = allow;
	}

	@Basic
	@Column(name = "allowoverlap", length = -1)
	public String getAllowoverlap() {
		return allowoverlap;
	}

	public void setAllowoverlap(String allowoverlap) {
		this.allowoverlap = allowoverlap;
	}

	@Basic
	@Column(name = "allowsubscribe", length = -1)
	public String getAllowsubscribe() {
		return allowsubscribe;
	}

	public void setAllowsubscribe(String allowsubscribe) {
		this.allowsubscribe = allowsubscribe;
	}

	@Basic
	@Column(name = "allowtransfer", length = -1)
	public String getAllowtransfer() {
		return allowtransfer;
	}

	public void setAllowtransfer(String allowtransfer) {
		this.allowtransfer = allowtransfer;
	}

	@Basic
	@Column(name = "amaflags", length = -1)
	public String getAmaflags() {
		return amaflags;
	}

	public void setAmaflags(String amaflags) {
		this.amaflags = amaflags;
	}

	@Basic
	@Column(name = "autoframing", length = -1)
	public String getAutoframing() {
		return autoframing;
	}

	public void setAutoframing(String autoframing) {
		this.autoframing = autoframing;
	}

	@Basic
	@Column(name = "auth", length = -1)
	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	@Basic
	@Column(name = "buggymwi", length = -1)
	public String getBuggymwi() {
		return buggymwi;
	}

	public void setBuggymwi(String buggymwi) {
		this.buggymwi = buggymwi;
	}

	@Basic
	@Column(name = "callgroup", length = -1)
	public String getCallgroup() {
		return callgroup;
	}

	public void setCallgroup(String callgroup) {
		this.callgroup = callgroup;
	}

	@Basic
	@Column(name = "callerid", length = -1)
	public String getCallerid() {
		return callerid;
	}

	public void setCallerid(String callerid) {
		this.callerid = callerid;
	}

	@Basic
	@Column(name = "cid_number", length = -1)
	public String getCidNumber() {
		return cidNumber;
	}

	public void setCidNumber(String cidNumber) {
		this.cidNumber = cidNumber;
	}

	@Basic
	@Column(name = "fullname", length = -1)
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Basic
	@Column(name = "`call-limit`", nullable = true)
	public Integer getCallLimit() {
		return callLimit;
	}

	public void setCallLimit(Integer callLimit) {
		this.callLimit = callLimit;
	}

	@Basic
	@Column(name = "callingpres", length = -1)
	public String getCallingpres() {
		return callingpres;
	}

	public void setCallingpres(String callingpres) {
		this.callingpres = callingpres;
	}

	@Basic
	@Column(name = "canreinvite", length = -1)
	public String getCanreinvite() {
		return canreinvite;
	}

	public void setCanreinvite(String canreinvite) {
		this.canreinvite = canreinvite;
	}

	@Basic
	@Column(name = "context", length = -1)
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Basic
	@Column(name = "defaultip", length = -1)
	public String getDefaultip() {
		return defaultip;
	}

	public void setDefaultip(String defaultip) {
		this.defaultip = defaultip;
	}

	@Basic
	@Column(name = "dtmfmode", length = -1)
	public String getDtmfmode() {
		return dtmfmode;
	}

	public void setDtmfmode(String dtmfmode) {
		this.dtmfmode = dtmfmode;
	}

	@Basic
	@Column(name = "fromuser", length = -1)
	public String getFromuser() {
		return fromuser;
	}

	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}

	@Basic
	@Column(name = "fromdomain", length = -1)
	public String getFromdomain() {
		return fromdomain;
	}

	public void setFromdomain(String fromdomain) {
		this.fromdomain = fromdomain;
	}

	@Basic
	@Column(name = "fullcontact", length = -1)
	public String getFullcontact() {
		return fullcontact;
	}

	public void setFullcontact(String fullcontact) {
		this.fullcontact = fullcontact;
	}

	@Basic
	@Column(name = "g726nonstandard", length = -1)
	public String getG726Nonstandard() {
		return g726Nonstandard;
	}

	public void setG726Nonstandard(String g726Nonstandard) {
		this.g726Nonstandard = g726Nonstandard;
	}

	@Basic
	@Column(name = "host", nullable = false, length = -1)
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Basic
	@Column(name = "insecure", length = -1)
	public String getInsecure() {
		return insecure;
	}

	public void setInsecure(String insecure) {
		this.insecure = insecure;
	}

	@Basic
	@Column(name = "ipaddr", nullable = false, length = -1)
	public String getIpaddr() {
		return ipaddr;
	}

	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}

	@Basic
	@Column(name = "language", length = -1)
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Basic
	@Column(name = "lastms", length = -1)
	public String getLastms() {
		return lastms;
	}

	public void setLastms(String lastms) {
		this.lastms = lastms;
	}

	@Basic
	@Column(name = "mailbox", length = -1)
	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	@Basic
	@Column(name = "maxcallbitrate", nullable = true)
	public Integer getMaxcallbitrate() {
		return maxcallbitrate;
	}

	public void setMaxcallbitrate(Integer maxcallbitrate) {
		this.maxcallbitrate = maxcallbitrate;
	}

	@Basic
	@Column(name = "mohsuggest", length = -1)
	public String getMohsuggest() {
		return mohsuggest;
	}

	public void setMohsuggest(String mohsuggest) {
		this.mohsuggest = mohsuggest;
	}

	@Basic
	@Column(name = "md5secret", length = -1)
	public String getMd5Secret() {
		return md5Secret;
	}

	public void setMd5Secret(String md5Secret) {
		this.md5Secret = md5Secret;
	}

	@Basic
	@Column(name = "musiconhold", length = -1)
	public String getMusiconhold() {
		return musiconhold;
	}

	public void setMusiconhold(String musiconhold) {
		this.musiconhold = musiconhold;
	}

	@Basic
	@Column(name = "name", nullable = false, length = -1)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "nat", nullable = false, length = -1)
	public String getNat() {
		return nat;
	}

	public void setNat(String nat) {
		this.nat = nat;
	}

	@Basic
	@Column(name = "outboundproxy", length = -1)
	public String getOutboundproxy() {
		return outboundproxy;
	}

	public void setOutboundproxy(String outboundproxy) {
		this.outboundproxy = outboundproxy;
	}

	@Basic
	@Column(name = "deny", length = -1)
	public String getDeny() {
		return deny;
	}

	public void setDeny(String deny) {
		this.deny = deny;
	}

	@Basic
	@Column(name = "permit", length = -1)
	public String getPermit() {
		return permit;
	}

	public void setPermit(String permit) {
		this.permit = permit;
	}

	@Basic
	@Column(name = "pickupgroup", length = -1)
	public String getPickupgroup() {
		return pickupgroup;
	}

	public void setPickupgroup(String pickupgroup) {
		this.pickupgroup = pickupgroup;
	}

	@Basic
	@Column(name = "port", nullable = false, length = -1)
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Basic
	@Column(name = "progressinband", nullable = false, length = -1)
	public String getProgressinband() {
		return progressinband;
	}

	public void setProgressinband(String progressinband) {
		this.progressinband = progressinband;
	}

	@Basic
	@Column(name = "promiscredir", length = -1)
	public String getPromiscredir() {
		return promiscredir;
	}

	public void setPromiscredir(String promiscredir) {
		this.promiscredir = promiscredir;
	}

	@Basic
	@Column(name = "qualify", length = -1)
	public String getQualify() {
		return qualify;
	}

	public void setQualify(String qualify) {
		this.qualify = qualify;
	}

	@Basic
	@Column(name = "regexten", nullable = false, length = -1)
	public String getRegexten() {
		return regexten;
	}

	public void setRegexten(String regexten) {
		this.regexten = regexten;
	}

	@Basic
	@Column(name = "regseconds", nullable = false)
	public Long getRegseconds() {
		return regseconds;
	}

	public void setRegseconds(Long regseconds) {
		this.regseconds = regseconds;
	}

	@Basic
	@Column(name = "rfc2833compensate", nullable = false, length = -1)
	public String getRfc2833Compensate() {
		return rfc2833Compensate;
	}

	public void setRfc2833Compensate(String rfc2833Compensate) {
		this.rfc2833Compensate = rfc2833Compensate;
	}

	@Basic
	@Column(name = "rtptimeout", length = -1)
	public String getRtptimeout() {
		return rtptimeout;
	}

	public void setRtptimeout(String rtptimeout) {
		this.rtptimeout = rtptimeout;
	}

	@Basic
	@Column(name = "rtpholdtimeout", length = -1)
	public String getRtpholdtimeout() {
		return rtpholdtimeout;
	}

	public void setRtpholdtimeout(String rtpholdtimeout) {
		this.rtpholdtimeout = rtpholdtimeout;
	}

	@Basic
	@Column(name = "secret", length = -1)
	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Basic
	@Column(name = "sendrpid", nullable = false, length = -1)
	public String getSendrpid() {
		return sendrpid;
	}

	public void setSendrpid(String sendrpid) {
		this.sendrpid = sendrpid;
	}

	@Basic
	@Column(name = "setvar", nullable = false, length = -1)
	public String getSetvar() {
		return setvar;
	}

	public void setSetvar(String setvar) {
		this.setvar = setvar;
	}

	@Basic
	@Column(name = "subscribecontext", length = -1)
	public String getSubscribecontext() {
		return subscribecontext;
	}

	public void setSubscribecontext(String subscribecontext) {
		this.subscribecontext = subscribecontext;
	}

	@Basic
	@Column(name = "subscribemwi", length = -1)
	public String getSubscribemwi() {
		return subscribemwi;
	}

	public void setSubscribemwi(String subscribemwi) {
		this.subscribemwi = subscribemwi;
	}

	@Basic
	@Column(name = "trustrpid", length = -1)
	public String getTrustrpid() {
		return trustrpid;
	}

	public void setTrustrpid(String trustrpid) {
		this.trustrpid = trustrpid;
	}

	@Basic
	@Column(name = "type", nullable = false, length = -1)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Basic
	@Column(name = "useclientcode", nullable = false, length = -1)
	public String getUseclientcode() {
		return useclientcode;
	}

	public void setUseclientcode(String useclientcode) {
		this.useclientcode = useclientcode;
	}

	@Basic
	@Column(name = "defaultuser", nullable = false, length = -1)
	public String getDefaultuser() {
		return defaultuser;
	}

	public void setDefaultuser(String defaultuser) {
		this.defaultuser = defaultuser;
	}

	@Basic
	@Column(name = "usereqphone", nullable = false, length = -1)
	public String getUsereqphone() {
		return usereqphone;
	}

	public void setUsereqphone(String usereqphone) {
		this.usereqphone = usereqphone;
	}

	@Basic
	@Column(name = "videosupport", nullable = false, length = -1)
	public String getVideosupport() {
		return videosupport;
	}

	public void setVideosupport(String videosupport) {
		this.videosupport = videosupport;
	}

	@Basic
	@Column(name = "vmexten", length = -1)
	public String getVmexten() {
		return vmexten;
	}

	public void setVmexten(String vmexten) {
		this.vmexten = vmexten;
	}

	@Basic
	@Column(name = "t38pt_udptl", nullable = false, length = -1)
	public String getT38PtUdptl() {
		return t38PtUdptl;
	}

	public void setT38PtUdptl(String t38PtUdptl) {
		this.t38PtUdptl = t38PtUdptl;
	}

	@Basic
	@Column(name = "useragent", length = -1)
	public String getUseragent() {
		return useragent;
	}

	public void setUseragent(String useragent) {
		this.useragent = useragent;
	}

	@Basic
	@Column(name = "username", length = -1)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Basic
	@Column(name = "regserver", length = -1)
	public String getRegserver() {
		return regserver;
	}

	public void setRegserver(String regserver) {
		this.regserver = regserver;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SipUser)) return false;
		SipUser sipUser = (SipUser) o;
		return Objects.equals(id, sipUser.id);
	}

	@Override
	public String toString() {
		return "SipUser{" +
				"id=" + id +
				", fullname='" + fullname + '\'' +
				", fullcontact='" + fullcontact + '\'' +
				", ipaddr='" + ipaddr + '\'' +
				", username='" + username + '\'' +
				'}';
	}
}
