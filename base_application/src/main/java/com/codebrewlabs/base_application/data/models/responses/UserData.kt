package com.codebrewlabs.base_application.data.models.responses

import java.io.Serializable

class UserData : Serializable {
    var id: String? = null
    var accessToken:String?=null
    var isFollowed: Boolean? = false
    var followedCount: Int? = 0
    var followingCount: Int? = 0
    var isTeamMember: Boolean = false
    var isHired: Int? = null
    var contractId: String? = null
    var mirrorFlyToken: String? = null
    var JID: String? = null
    var jid: String? = null
    var mirrorfly: Boolean? = null
    var mirrorflyPassword: String? = null
    var isFriend: String? = null
    var isFavorite: Boolean? = null
    var favoriteCount: Int? = null
    var feedbackRating: Float? = 0.0f
    var feedbackCount: Long? = 0
    var joiningReferralCode: String? = null
}
