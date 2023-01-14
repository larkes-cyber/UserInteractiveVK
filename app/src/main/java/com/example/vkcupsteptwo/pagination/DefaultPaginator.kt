package com.example.vkcupsteptwo.pagination

class DefaultPaginator<Key, T>(
    private val initialKey:Key,
    private inline val onLoadUpdated: (Boolean) -> Unit,
    private inline val onRequest: suspend (nextKey:Key) -> Result<List<T>>,
    private inline val getNextKey:suspend (List<T>) -> Key,
    private inline val onSuccess: suspend (items:List<T>, newKey:Key) -> Unit
 ):Paginator<Key, T> {

    private var currencyKey = initialKey
    private var isMakingRequest = false

    override suspend fun loadNextItems() {

        if(isMakingRequest){
            return
        }
        isMakingRequest = true
        onLoadUpdated(true)
        val result = onRequest(currencyKey)
        isMakingRequest = false
        val items = result.getOrElse {
            onLoadUpdated(false)
            return
        }
        currencyKey = getNextKey(items)
        onSuccess(items, currencyKey)
        onLoadUpdated(false)
    }

    override fun reset() {
    }
}