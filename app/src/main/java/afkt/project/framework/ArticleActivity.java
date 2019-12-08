package afkt.project.framework;

import afkt.project.base.app.BaseMVPToolbarActivity;
import afkt.project.framework.mvp.ArticleMVP;

/**
 * detail: 文章 Activity
 * @author Ttt
 */
public class ArticleActivity extends BaseMVPToolbarActivity<ArticleMVP.Presenter> {

    @Override
    protected ArticleMVP.Presenter presenter() {
        return new ArticleMVP.Presenter();
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initValues() {
        super.initValues();
        // 获取文章列表
        mPresenter.getArticleLists();
    }
}