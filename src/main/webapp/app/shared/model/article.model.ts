import { Moment } from 'moment';
import { ITag } from 'app/shared/model/tag.model';

export interface IArticle {
  id?: number;
  userId?: number;
  title?: string;
  articleBody?: string;
  dateArticle?: string;
  tags?: ITag[];
  applicationUserId?: number;
}

export const defaultValue: Readonly<IArticle> = {};
