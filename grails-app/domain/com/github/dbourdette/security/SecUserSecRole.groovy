package com.github.dbourdette.security

import org.apache.commons.lang.builder.HashCodeBuilder

class SecUserSecRole implements Serializable {

	static mapWith = 'mongo'
	SecUser user
	SecRole role

	boolean equals(other) {
		if (!(other instanceof SecUserSecRole)) {
			return false
		}

		other.user?.id == user?.id &&
			other.role?.id == role?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (user) builder.append(user.id)
		if (role) builder.append(role.id)
		builder.toHashCode()
	}

	static SecUserSecRole get(long userId, long roleId) {
		find 'from UserRole where user.id=:userId and role.id=:roleId',
			[userId: userId, roleId: roleId]
	}

	static SecUserSecRole create(SecUser user, SecRole role, boolean flush = false) {
		new SecUserSecRole(user: user, role: role).save(flush: flush, insert: true)
	}

	static boolean remove(SecUser user, SecRole role, boolean flush = false) {
		SecUserSecRole instance = SecUserSecRole.findByUserAndRole(user, role)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(SecUser user) {
		executeUpdate 'DELETE FROM UserRole WHERE user=:user', [user: user]
	}

	static void removeAll(SecRole role) {
		executeUpdate 'DELETE FROM UserRole WHERE role=:role', [role: role]
	}

	static mapping = {
		id composite: ['role', 'user']
		version false
	}
}
