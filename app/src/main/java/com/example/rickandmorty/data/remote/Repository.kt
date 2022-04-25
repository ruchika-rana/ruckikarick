package com.example.rickandmorty.data.remote

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmorty.data.model.CharactersModel
import com.example.rickandmorty.network.RetrofitInterface


class Repository(private val retroInterface: RetrofitInterface): PagingSource<Int,CharactersModel>(){
    override fun getRefreshKey(state: PagingState<Int, CharactersModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharactersModel> {
        return try{
            val nextPage:Int = params.key?:FIRST_PAGE_INDEX
            val response=retroInterface.getAPI(nextPage)
            var nextNumber:Int?=null
            if(response?.info.next!=null)
            {
                val uri= Uri.parse(response?.info?.next!!)
                val nextPageQuery = uri.getQueryParameter("page")
                nextNumber = nextPageQuery?.toInt()
            }

            var prevNumber:Int? = null
            if(response?.info.prev!=null)
            {
                val uri= Uri.parse(response?.info?.prev!!)
                val prevPageQuery = uri.getQueryParameter("page")
                prevNumber = prevPageQuery?.toInt()
            }

            LoadResult.Page(data=response.result,
            prevKey = prevNumber,
            nextKey = nextNumber)
        }catch (e:Exception){
            LoadResult.Error(e)
        }

    }
    companion object{
        private const val FIRST_PAGE_INDEX = 1
    }

}