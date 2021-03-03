import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './article.reducer';
import { IArticle } from 'app/shared/model/article.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IArticleDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const ArticleDetail = (props: IArticleDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { articleEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="zimaApp.article.detail.title">Article</Translate> [<b>{articleEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="userId">
              <Translate contentKey="zimaApp.article.userId">User Id</Translate>
            </span>
          </dt>
          <dd>{articleEntity.userId}</dd>
          <dt>
            <span id="title">
              <Translate contentKey="zimaApp.article.title">Title</Translate>
            </span>
          </dt>
          <dd>{articleEntity.title}</dd>
          <dt>
            <span id="articleBody">
              <Translate contentKey="zimaApp.article.articleBody">Article Body</Translate>
            </span>
          </dt>
          <dd>{articleEntity.articleBody}</dd>
          <dt>
            <span id="dateArticle">
              <Translate contentKey="zimaApp.article.dateArticle">Date Article</Translate>
            </span>
          </dt>
          <dd>
            {articleEntity.dateArticle ? <TextFormat value={articleEntity.dateArticle} type="date" format={APP_LOCAL_DATE_FORMAT} /> : null}
          </dd>
          <dt>
            <Translate contentKey="zimaApp.article.tags">Tags</Translate>
          </dt>
          <dd>
            {articleEntity.tags
              ? articleEntity.tags.map((val, i) => (
                  <span key={val.id}>
                    <a>{val.id}</a>
                    {articleEntity.tags && i === articleEntity.tags.length - 1 ? '' : ', '}
                  </span>
                ))
              : null}
          </dd>
          <dt>
            <Translate contentKey="zimaApp.article.applicationUser">Application User</Translate>
          </dt>
          <dd>{articleEntity.applicationUserId ? articleEntity.applicationUserId : ''}</dd>
        </dl>
        <Button tag={Link} to="/article" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/article/${articleEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ article }: IRootState) => ({
  articleEntity: article.entity,
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(ArticleDetail);
