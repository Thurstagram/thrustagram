package umc.thurstagram.service.postHashtagService;

import umc.thurstagram.domain.Post;
import umc.thurstagram.domain.PostHashtag;

public interface PostHashtagService {

    PostHashtag getPostHashtagByPost(Post post);

}
