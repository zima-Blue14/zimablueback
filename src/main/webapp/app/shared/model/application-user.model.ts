import { IArticle } from 'app/shared/model/article.model';

export interface IApplicationUser {
  id?: number;
  profilBanner?: string;
  profilBio?: string;
  internalUserId?: number;
  articles?: IArticle[];
  friends?: IApplicationUser[];
  followers?: IApplicationUser[];
}

export const defaultValue: Readonly<IApplicationUser> = {};
