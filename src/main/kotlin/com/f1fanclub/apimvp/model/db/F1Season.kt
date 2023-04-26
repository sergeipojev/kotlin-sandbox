package com.f1fanclub.apimvp.model.db

import com.f1fanclub.apimvp.model.dto.F1SeasonInfo
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.UUID

@Document("f1_seasons")
data class F1Season(
    @Id val id: String?,
    @Field("season_year")
    @Indexed(unique = true)
    val season: Int,
    @Field("season_wiki") val wikiPage: String,
) {

    fun toDto() = F1SeasonInfo(
        id = this.id ?: UUID.randomUUID().toString(),
        season = this.season,
        wikiPage = this.wikiPage,
    )
}
