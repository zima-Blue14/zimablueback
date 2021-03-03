import { IArticle } from 'app/shared/model/article.model';

export interface ITag {
  id?: number;
  libelle?: string;
  articles?: IArticle[];
}

export const defaultValue: Readonly<ITag> = {};
