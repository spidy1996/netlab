BEGIN {
}
{
if($6==&quot;cwnd_&quot;)
printf(&quot;%f\t%f\t\n&quot;,$1,$7);
}
END{
}
