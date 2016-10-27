/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.credential;

import java.util.Objects;

/**
 * Created on 21.06.16.
 * Asterisk credentials holder.
 *
 * @author atelizhenko
 */
public final class AsteriskCredential {
	/**
	 * Domain or ip
	 */
	private final String domain;
	/**
	 * Port
	 */
	private final Integer port;
	/**
	 * Login
	 */
	private final String login;
	/**
	 * Password
	 */
	private final String password;
	/**
	 * Secured connection
	 */
	private final boolean secured;

	/**
	 * Constructor
	 *
	 * @param builder builder
	 */
	private AsteriskCredential(Builder builder) {
		domain = builder.domain;
		port = builder.port;
		login = builder.login;
		password = builder.password;
		secured = builder.secured;
	}

	/**
	 * Gets domain.
	 *
	 * @return the domain
	 */
	public final String getDomain() {
		return domain;
	}

	/**
	 * Gets port.
	 *
	 * @return the port
	 */
	public final int getPort() {
		return port;
	}

	/**
	 * Gets login.
	 *
	 * @return the login
	 */
	public final String getLogin() {
		return login;
	}

	/**
	 * Gets password.
	 *
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 * Is secured boolean.
	 *
	 * @return the boolean
	 */
	public final boolean isSecured() {
		return secured;
	}

	@Override
	public int hashCode() {
		return Objects.hash(domain, port, login, password, secured);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AsteriskCredential)) return false;
		AsteriskCredential that = (AsteriskCredential) o;
		return secured == that.secured &&
				Objects.equals(domain, that.domain) &&
				Objects.equals(port, that.port) &&
				Objects.equals(login, that.login);
	}

	@Override
	public String toString() {
		return "AsteriskCredential{" +
				"domain='" + domain + '\'' +
				", port=" + port +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", secured=" + secured +
				'}';
	}

	/**
	 * {@code AsteriskCredential} builder static inner class.
	 */
	public static final class Builder {
		private String domain;
		private Integer port;
		private String login;
		private String password;
		private boolean secured;

		/**
		 * Instantiates a new Builder.
		 */
		public Builder() {
		}

		public Builder(AsteriskCredential copy) {
			this.domain = copy.domain;
			this.port = copy.port;
			this.login = copy.login;
			this.password = copy.password;
			this.secured = copy.secured;
		}

		/**
		 * Sets the {@code domain} and returns a reference to this Builder so that the methods can be chained together.
		 *
		 * @param val the {@code domain} to set
		 * @return a reference to this Builder
		 */
		public final Builder domain(String val) {
			domain = val;
			return this;
		}

		/**
		 * Sets the {@code port} and returns a reference to this Builder so that the methods can be chained together.
		 *
		 * @param val the {@code port} to set
		 * @return a reference to this Builder
		 */
		public final Builder port(Integer val) {
			port = val;
			return this;
		}

		/**
		 * Sets the {@code login} and returns a reference to this Builder so that the methods can be chained together.
		 *
		 * @param val the {@code login} to set
		 * @return a reference to this Builder
		 */
		public final Builder login(String val) {
			login = val;
			return this;
		}

		/**
		 * Sets the {@code password} and returns a reference to this Builder so that the methods can be chained together.
		 *
		 * @param val the {@code password} to set
		 * @return a reference to this Builder
		 */
		public final Builder password(String val) {
			password = val;
			return this;
		}

		/**
		 * Sets the {@code secured} and returns a reference to this Builder so that the methods can be chained together.
		 *
		 * @param val the {@code secured} to set
		 * @return a reference to this Builder
		 */
		public final Builder secured(boolean val) {
			secured = val;
			return this;
		}

		/**
		 * Returns a {@code AsteriskCredential} built from the parameters previously set.
		 *
		 * @return a {@code AsteriskCredential} built with parameters of this {@code AsteriskCredential.Builder}
		 */
		public final AsteriskCredential build() {
			return new AsteriskCredential(this);
		}
	}
}
