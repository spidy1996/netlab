BEGIN{
drop=0;
}
{
if($1==&quot;d&quot;)
{
drop++;
}
}
END{
printf(&quot;Total number of %s packets dropped due to congestion=%d\n&quot;,$5,drop);
}
