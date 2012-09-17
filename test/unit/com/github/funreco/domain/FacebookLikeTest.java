package com.github.funreco.domain;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class FacebookLikeTest {
    @Test
    public void fromJson() throws IOException {
        List<FacebookLike> likes = FacebookLike.fromJson(json());

        assertThat(likes).isNotEmpty();
        assertThat(likes.get(0).getName()).isEqualTo("PROMOD");
        assertThat(likes.get(2).getName()).isEqualTo("Bruno Guillon");
    }

    private String json() {
        return "{\n" +
                "   \"data\": [\n" +
                "      {\n" +
                "         \"name\": \"PROMOD\",\n" +
                "         \"category\": \"Retail and consumer merchandise\",\n" +
                "         \"id\": \"108766692776\",\n" +
                "         \"created_time\": \"2012-06-22T10:05:16+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"athlenergy.com\",\n" +
                "         \"category\": \"Website\",\n" +
                "         \"id\": \"120366741307328\",\n" +
                "         \"created_time\": \"2012-06-19T10:51:17+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"Bruno Guillon\",\n" +
                "         \"category\": \"Public figure\",\n" +
                "         \"id\": \"19428019894\",\n" +
                "         \"created_time\": \"2012-06-18T11:37:58+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"Arthus & Co.\",\n" +
                "         \"category\": \"Baby goods/kids goods\",\n" +
                "         \"id\": \"192892604807\",\n" +
                "         \"created_time\": \"2012-06-12T20:14:56+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"NRJ\",\n" +
                "         \"category\": \"Radio station\",\n" +
                "         \"id\": \"39824562567\",\n" +
                "         \"created_time\": \"2012-05-16T09:35:14+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"Du Pareil Au M\\u00eame\",\n" +
                "         \"category\": \"Company\",\n" +
                "         \"id\": \"112767798743890\",\n" +
                "         \"created_time\": \"2012-05-13T06:01:28+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"Se Coucher Moins B\\u00eate - Pour briller en soir\\u00e9e\",\n" +
                "         \"category\": \"Website\",\n" +
                "         \"id\": \"148408955226893\",\n" +
                "         \"created_time\": \"2012-05-11T11:09:34+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"Air France Music\",\n" +
                "         \"category\": \"Playlist\",\n" +
                "         \"id\": \"180578563262\",\n" +
                "         \"created_time\": \"2012-04-19T12:13:16+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"Covered\",\n" +
                "         \"category\": \"Album\",\n" +
                "         \"id\": \"281888618557029\",\n" +
                "         \"created_time\": \"2012-04-19T08:31:07+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"Hanouna le matin\",\n" +
                "         \"category\": \"Radio station\",\n" +
                "         \"id\": \"129096687176066\",\n" +
                "         \"created_time\": \"2012-04-03T12:29:17+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"Deezer\",\n" +
                "         \"category\": \"Website\",\n" +
                "         \"id\": \"173259534981\",\n" +
                "         \"created_time\": \"2012-03-08T17:55:12+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"CoachClub.fr\",\n" +
                "         \"category\": \"Recreation/sports\",\n" +
                "         \"id\": \"168252071257\",\n" +
                "         \"created_time\": \"2012-02-21T21:39:06+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"DMK\",\n" +
                "         \"category\": \"Musician/band\",\n" +
                "         \"id\": \"386334131381718\",\n" +
                "         \"created_time\": \"2012-02-21T21:04:25+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"Justice\",\n" +
                "         \"category\": \"Musician/band\",\n" +
                "         \"id\": \"39082832518\",\n" +
                "         \"created_time\": \"2012-02-04T20:45:44+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"Cosmos Carl Sagan\",\n" +
                "         \"category\": \"Book\",\n" +
                "         \"id\": \"106356432725565\",\n" +
                "         \"created_time\": \"2012-02-04T20:31:42+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"Depeche Mode\",\n" +
                "         \"category\": \"Musician/band\",\n" +
                "         \"id\": \"26101560328\",\n" +
                "         \"created_time\": \"2012-02-04T20:26:35+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"Fun Radio Inside\",\n" +
                "         \"category\": \"Radio station\",\n" +
                "         \"id\": \"282052901843314\",\n" +
                "         \"created_time\": \"2012-02-02T16:37:17+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"Bruno dans la radio 6h-9h sur Fun Radio\",\n" +
                "         \"category\": \"Radio station\",\n" +
                "         \"id\": \"170367476360580\",\n" +
                "         \"created_time\": \"2012-02-02T16:33:05+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"PARTY FUN OFFICIEL\",\n" +
                "         \"category\": \"Radio station\",\n" +
                "         \"id\": \"114153571945520\",\n" +
                "         \"created_time\": \"2012-02-02T16:30:31+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"KAREL LIBRE ANTENNE OFFICIEL\",\n" +
                "         \"category\": \"Public figure\",\n" +
                "         \"id\": \"377201145705\",\n" +
                "         \"created_time\": \"2012-01-30T22:10:09+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"Compassion in World Farming\",\n" +
                "         \"category\": \"Non-profit organization\",\n" +
                "         \"id\": \"10499876484\",\n" +
                "         \"created_time\": \"2011-11-30T18:10:47+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"TV5MONDE\",\n" +
                "         \"category\": \"Media/news/publishing\",\n" +
                "         \"id\": \"126814579407\",\n" +
                "         \"created_time\": \"2011-11-30T17:58:00+0000\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"name\": \"FUN RADIO\",\n" +
                "         \"category\": \"Movies/music\",\n" +
                "         \"id\": \"40749759802\",\n" +
                "         \"created_time\": \"2011-11-29T23:12:20+0000\"\n" +
                "      }\n" +
                "   ],\n" +
                "   \"paging\": {\n" +
                "      \"next\": \"https://graph.facebook.com/538554196/likes?access_token=AAACxdEK8FZAABAHi8s8qRnZCEDVRrQXzocQDQ0wJ09haeZBgWM4R3mfUgp5XnKZAlHFFKhsM1qqFMP3ba7v3cD3qCac7fkCSo6dlnZAzJ9AZDZD&limit=5000&offset=5000&__after_id=40749759802\"\n" +
                "   }\n" +
                "}";
    }
}
